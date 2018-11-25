import React, {Component} from "react";
import {Redirect, Route, Switch} from "react-router-dom";

import LoginPage from "../LoginPage";
import RegistrationPage from "../RegistrationPage";
import DashboardPage from "../DashboardPage";
import NotFoundPage from "../NotFoundPage";

class App extends Component {
    render() {
        return (
            <Switch>
                <Redirect exact from="/" to="/dashboard"/>
                <Route path="/login" component={LoginPage}/>
                <Route path="/registration" component={RegistrationPage}/>
                <Route path="/dashboard" component={DashboardPage}/>
                <Route component={NotFoundPage}/>
            </Switch>
        );
    }
}

export default App;
