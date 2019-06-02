import React, { Component } from "react";
import model from "../model/model";

import CreateQuestion from "./CreateQuestion";
import createQuestionPresenter from "../presenter/createQuestionPresenter";

const mapModelStateToComponentState = modelState => ({
    title: modelState.newQuestion.title,
    question: modelState.newQuestion.question,
    author: modelState.newQuestion.author,
    date: modelState.newQuestion.date,
    tags: modelState.newQuestion.tags

});

export default class SmartCreateQuestion extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <CreateQuestion
                onCreate={createQuestionPresenter.onCreate}
                onChange={createQuestionPresenter.onChange}
                title={this.state.title}
                question={this.state.question}
                author={this.state.author}
                date={this.state.date}
                tags={this.state.tags}/>
        );
    }
}
