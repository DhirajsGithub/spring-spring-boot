import React, { useState, useEffect, useRef } from 'react';
import { 
  FaPlus, 
  FaTimes, 
  FaCalendarAlt, 
  FaTag, 
  FaAlignLeft, 
  FaCheckCircle 
} from 'react-icons/fa';
import "../styles/addTodoStyle.css";

const AddTodo = ({ isOpen, onClose, onAdd }) => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [targetDate, setTargetDate] = useState('');
  const [done, setDone] = useState(false);
  const titleInputRef = useRef(null);

  // Auto-focus on title input when modal opens
  useEffect(() => {
    if (isOpen && titleInputRef.current) {
      titleInputRef.current.focus();
    }
  }, [isOpen]);

  // Reset form when modal closes
  useEffect(() => {
    if (!isOpen) {
      setTitle('');
      setDescription('');
      setTargetDate('');
      setDone(false);
    }
  }, [isOpen]);

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Basic validation
    if (!title.trim()) {
      alert('Please enter a task title');
      return;
    }

    // Create new todo
    const newTodo = {
      id: Date.now(),
      title: title.trim(),
      description: description.trim(),
      targetDate,
      done
    };

    // Add todo and close modal
    onAdd(newTodo);
    onClose();
  };

  // Prevent modal from closing when clicking inside
  const handleModalClick = (e) => {
    e.stopPropagation();
  };

  // Render nothing if modal is not open
  if (!isOpen) return null;

  return (
    <div className="todo-modal-overlay" onClick={onClose}>
      <div 
        className="todo-modal-container" 
        onClick={handleModalClick}
      >
        <form onSubmit={handleSubmit} className="todo-modal-form">
          <div className="modal-header">
            <h2>
              <FaPlus className="header-icon" />
              Create New Task
            </h2>
            <button 
              type="button" 
              className="close-button" 
              onClick={onClose}
            >
              <FaTimes />
            </button>
          </div>

          <div className="form-section">
            <div className="input-wrapper">
              <FaTag className="input-icon" />
              <input
                ref={titleInputRef}
                type="text"
                placeholder="What's your task?"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
                maxLength={100}
                required
              />
            </div>

            <div className="input-wrapper">
              <FaAlignLeft className="input-icon" />
              <textarea
                placeholder="Add some details (optional)"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                maxLength={300}
                rows={3}
              ></textarea>
            </div>

            <div className="form-row">
              <div className="input-wrapper date-input">
                <FaCalendarAlt className="input-icon" />
                <input
                  type="date"
                  value={targetDate}
                  onChange={(e) => setTargetDate(e.target.value)}
                  required
                />
              </div>

             
            </div>
          </div>

          <div className="modal-actions">
            <button 
              type="button" 
              className="cancel-button" 
              onClick={onClose}
            >
              Cancel
            </button>
            <button 
              type="submit" 
              className="create-button"
            >
              Create Task
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AddTodo;