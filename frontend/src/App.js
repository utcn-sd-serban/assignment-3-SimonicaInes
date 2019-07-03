import React from 'react';
import './App.css';


import { HashRouter, Switch, Route } from "react-router-dom";
import SmartQuestionsList from './view/SmartQuestionsList';
import SmartCreateQuestion from './view/SmartCreateQuestion';
import SmartLogger from './view/SmartLogger';
import SmartFilterByTitle from './view/SmartFilterByTitle';

const App = () => (
  <div className="App">
    <HashRouter>
      <Switch>
        <Route exact={true} component={SmartLogger} path="/" />
        <Route exact={true} component={SmartQuestionsList} path="/questions" />
        <Route exact={true} component={SmartFilterByTitle} path="/filter-title-question" />
        <Route exact={true} component={SmartCreateQuestion} path="/create-question" />
      </Switch>
    </HashRouter>
  </div>
);


export default App;
