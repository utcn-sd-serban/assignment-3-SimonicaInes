import React from "react";

const CreateQuestion = ({ title, question,author,date,tags, onCreate, onChange }) => (
    <div>
        <h2>Add Question</h2>
        <div>
            <label>Title: </label>
            <input value={title} data-cy="title"
                onChange={ e => onChange("title", e.target.value) } />
            <br />
            <label>Question: </label>
            <input value={question}  data-cy="question"
                onChange={ e => onChange("question", e.target.value) } />
            <br />
            <label>Author: </label>
            <input value={author}  data-cy="author"
                   onChange={ e => onChange("author", e.target.value) } />
            <br />
            <label>Date: </label>
            <input value={date}  data-cy="date"
                   onChange={ e => onChange("date", e.target.value) } />
            <br />
            <label>Tags: </label>
            <input value={tags}  data-cy="tags"
                   onChange={ e => onChange("tags", e.target.value) } />
            <br />
            <button onClick={onCreate} data-cy="create">Create!</button>
        </div>
    </div>
);

export default CreateQuestion;