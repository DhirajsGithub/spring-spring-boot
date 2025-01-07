import React, { useState, useRef, useEffect } from 'react';
import { FaEdit, FaTrash, FaCheckCircle, FaCalendarAlt } from 'react-icons/fa';
import { calculateTimeRemaining, getTimeRemainingText } from '../utils/timeReamining';
import '../styles/todoStyle.css';

const Todo = ({ todo, onSave, onDelete }) => {
  const [isEditing, setIsEditing] = useState(false);
  const [tempTodo, setTempTodo] = useState({ ...todo });
  const titleInputRef = useRef(null);

  // Auto-focus on title input when editing starts
  useEffect(() => {
    if (isEditing && titleInputRef.current) {
      titleInputRef.current.focus();
    }
  }, [isEditing]);

  const handleEdit = () => setIsEditing(true);

  const handleCancel = () => {
    setTempTodo({ ...todo });
    setIsEditing(false);
  };

  const handleSave = () => {
    // Basic validation
    if (!tempTodo.title.trim()) {
      alert('Title cannot be empty');
      return;
    }
    
    onSave(tempTodo);
    setIsEditing(false);
  };

  const handleKeyDown = (e) => {
    // Save on Enter, Cancel on Escape
    if (e.key === 'Enter') handleSave();
    if (e.key === 'Escape') handleCancel();
  };

  const handleDelete = () => {
    if (window.confirm('Are you sure you want to delete this todo?')) {
      onDelete(todo.id);
    }
  };

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setTempTodo({
      ...tempTodo,
      [name]: type === 'checkbox' ? checked : value,
    });
  };

  // Calculate time remaining
  const timeRemaining = calculateTimeRemaining(todo.targetDate);

  // Determine time status class
  const getTimeStatusClass = () => {
    if (!timeRemaining) return '';
    if (timeRemaining.isPastDue) return 'overdue';
    if (timeRemaining.isSoon) return 'due-soon';
    return 'on-track';
  };

  return (
    <div className={`todo-card ${getTimeStatusClass()}`}>
      {isEditing ? (
        <div className="todo-edit-mode">
          <input
            ref={titleInputRef}
            type="text"
            name="title"
            value={tempTodo.title}
            onChange={handleChange}
            onKeyDown={handleKeyDown}
            className="todo-input"
            placeholder="What needs to be done?"
            maxLength={100}
          />
          <textarea
            name="description"
            value={tempTodo.description}
            onChange={handleChange}
            onKeyDown={handleKeyDown}
            className="todo-textarea"
            placeholder="Add details (optional)"
            maxLength={300}
          ></textarea>
          
          <div className="todo-edit-footer">
            <div className="todo-metadata">
              <div className="todo-field">
                <FaCalendarAlt />
                <input
                  type="date"
                  name="targetDate"
                  value={tempTodo.targetDate}
                  onChange={handleChange}
                  className="todo-date-input"
                />
              </div>
              <div className="todo-field">
                <FaCheckCircle />
                <input
                  type="checkbox"
                  name="done"
                  checked={tempTodo.done}
                  onChange={handleChange}
                  id="todo-done-checkbox"
                />
                <label htmlFor="todo-done-checkbox">Complete</label>
              </div>
            </div>
            <div className="todo-quick-save">
              <button onClick={handleSave}>Save</button>
              <button onClick={handleCancel}>Cancel</button>
            </div>
          </div>
        </div>
      ) : (
        <div className="todo-view-mode">
          <div className="todo-header">
            <h3 className={`todo-title ${todo.done ? 'completed' : ''}`}>
              {todo.title}
            </h3>
            <div className="todo-quick-actions">
              <button className='btn-edit' onClick={handleEdit} aria-label="Edit todo">
                <FaEdit />
              </button>
              <button className='btn-delete' onClick={handleDelete} aria-label="Delete todo">
                <FaTrash />
              </button>
            </div>
          </div>
          
          {todo.description && (
            <p className="todo-description">{todo.description}</p>
          )}
          
          <div className="todo-footer">
        
            <div className={`todo-time-status ${getTimeStatusClass()}`}>
              {getTimeRemainingText(todo.targetDate)}
            </div>
            {todo.done && (
              <div className="todo-status completed">
                <FaCheckCircle />
                <span>Completed</span>
              </div>
            )}
          </div>
        </div>
      )}
    </div>
  );
};

export default Todo;