import React, { Component } from "react";
import model from "../model/model";
import QuestionsList from "./QuestionsList";
import questionsListPresenter from "../presenter/questionsListPresenter";

const mapModelStateToComponentState = modelState => ({
    questions: modelState.questions
});

export default class SmartQuestionsList extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
        questionsListPresenter.onInit();
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <QuestionsList
                onCreateQuestion={questionsListPresenter.onCreateQuestion}
                questions={this.state.questions} />
        );
    }
}
