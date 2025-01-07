import { useContext, useState } from 'react';
import { FaPlus } from 'react-icons/fa';
import Todo from "../components/Todo";
import '../styles/todoPageStyle.css';
import AddTodo from '../components/AddTodo';
import Header from '../components/Header';
import {AuthContext} from '../store/authContext';

const TodoPage = () => {
  const ctx = useContext(AuthContext)
  const [todos, setTodos] = useState([
    {
      id: 1,
      title: 'Learn React',
      description: 'Complete the React course and build a project.',
      done: false,
      targetDate: '2024-12-31',
    },
    {
      id: 2,
      title: 'Finish Assignment',
      description: 'Complete the final project for the course.',
      done: false,
      targetDate: '2024-12-20',
    },
    {
      id: 3,
      title: 'Grocery Shopping',
      description: 'Buy ingredients for the week.',
      done: false,
      targetDate: '2024-12-18',
    },
  ]);

  // State to control modal visibility
  const [isAddModalOpen, setIsAddModalOpen] = useState(false);

  // Function to handle saving an edited todo
  const handleSaveTodo = (updatedTodo) => {
    setTodos((prevTodos) => {
      return prevTodos.map(todo =>
        todo.id === updatedTodo.id ? updatedTodo : todo
      );
    });
  };

  // Function to handle deleting a todo
  const handleDeleteTodo = (id) => {
    setTodos((prevTodos) => {
      return prevTodos.filter(todo => todo.id !== id);
    });
  };

  // Function to handle adding a new todo
  const handleAddTodo = (newTodo) => {
    setTodos((prevTodos) => [newTodo, ...prevTodos]);
  };

  if(!ctx.user){
    return null
  }

  return (
    <div className="todo-page-container">
      <Header ctx={ctx} />
      <div className="todo-page-header">
        <h1>My Todos</h1>
        <button 
          className="add-todo-btn" 
          onClick={() => setIsAddModalOpen(true)}
        >
          <FaPlus /> Add Todo
        </button>
      </div>

      {/* Add Todo Modal */}
      <AddTodo 
        isOpen={isAddModalOpen}
        onClose={() => setIsAddModalOpen(false)}
        onAdd={handleAddTodo}
      />

      <div className="todo-list">
        {todos.map(todo => (
          <Todo
            key={todo.id}
            todo={todo}
            onSave={handleSaveTodo}
            onDelete={handleDeleteTodo}
          />
        ))}
      </div>
    </div>
  );
};

export default TodoPage;