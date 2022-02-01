import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CakeList from './CakeList';
import CakeEdit from "./CakeEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/cakes' exact={true} component={CakeList}/>
            <Route path='/cakes/:id' component={CakeEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;