import React, { Component, useState } from 'react'
import { Editor } from 'react-draft-wysiwyg';
import { EditorState } from 'draft-js';

import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';
import './RulesEditor.css';

export default class TextEditor extends Component {

  state = {
    editorState: EditorState.createEmpty(),
    edit: true,
  }
  
  handleChange = () => {
    this.setState((state) => ({
      edit: !state.edit,
    }));
  }

  saveChange =() => {
    this.setState(() => ({
      edit: false
    }))
  }

  onEditorStateChange = (editorState) => {
    this.setState({
      editorState,
    });
  }

  render() {

    const {editorState} = this.state;
   

    if (!this.state.edit) {
      return (
        <>
          <button onClick={ this.handleChange }>Editar</button>
        </>
        
      );
    } else {
        return (
          <>
            <Editor
              editorState={editorState}
              toolbarClassName="toolbarClassName"
              wrapperClassName="wrapperClassName"
              editorClassName="editorClassName"
              onEditorStateChange={this.onEditorStateChange}
            />
            <button onClick={ this.saveChange }>Salvar</button>
          </>
        );
      }
  }
}
