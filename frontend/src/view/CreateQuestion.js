import React from "react";

const CreateQuestion = ({ authorId, title, text, tags, date, onCreate, onChange }) => (
    <div>
        <h2>Add Question</h2>
        <div>
            <label>Author Id: </label>
            <input value={authorId} data-cy="authorId"
                onChange={ e => onChange("authorId", e.target.value) } />
            <br />
            <label>Title: </label>
            <input value={title} data-cy="title"
                   onChange={ e => onChange("title", e.target.value) } />
            <br />
            <label>Text: </label>
            <input value={text} data-cy="text"
                   onChange={ e => onChange("text", e.target.value) } />
            <br />
            <label>Tags: </label>
            <input value={tags} data-cy="tags"
                   onChange={ e => onChange("tags", e.target.value) } />
            <br />
            <label>Date: </label>
            <input value={date} data-cy="date"
                   onChange={ e => onChange("date", e.target.value) } />
            <br />
            <button onClick={onCreate} data-cy="create">Create!</button>
        </div>
    </div>
);

export default CreateQuestion;