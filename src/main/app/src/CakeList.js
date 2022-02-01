import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavBar from './AppNavBar';
import { Link } from 'react-router-dom';

class CakeList extends Component {

    constructor(props) {
        super(props);
        this.state = {cakes: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/cakes')
            .then(response => response.json())
            .then(data => this.setState({cakes: data}));
    }

    async remove(id) {
        await fetch(`/cakes/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCakes = [...this.state.cakes].filter(i => i.id !== id);
            this.setState({cakes: updatedCakes});
        });
    }
    
    render() {
        const {cakes, isLoading} = this.state;
    
        if (isLoading) {
            return <p>Loading...</p>;
        }
    
        const cakeList = cakes.map(cake => {
            return <tr key={cake.id}>
                <td style={{whiteSpace: 'nowrap'}}>{cake.name}</td>
                <td>{cake.description}</td>
                <td>{cake.imageURL}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/cakes/" + cake.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(cake.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });
    
        return (
            <div>
                <AppNavBar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/cakes/new/">Add Cake</Button>
                    </div>
                    <h3>Cakes</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                            <th width="30%">Description</th>
                            <th width="40%">ImageURL</th>
                        </tr>
                        </thead>
                        <tbody>
                        {cakeList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default CakeList;