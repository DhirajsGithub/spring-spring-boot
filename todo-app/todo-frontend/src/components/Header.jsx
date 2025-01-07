import {useContext} from 'react';
import { FaSignOutAlt } from 'react-icons/fa'; 
import "../styles/headerStyle.css"
import {AuthContext} from '../store/authContext';
import {useNavigate} from 'react-router';

const Header = () => {
    const ctx = useContext(AuthContext)
    const navigation = useNavigate()
    const onLogout = () => {
        ctx.logout()
        navigation('/login')
    };
  return (
    <header className="header-container">
      <div className="welcome-message">
        <h2>Welcome, {ctx.user}</h2>
      </div>
      <button className="logout-button" onClick={onLogout}>
        <FaSignOutAlt /> Logout
      </button>
    </header>
  );
};

export default Header;
