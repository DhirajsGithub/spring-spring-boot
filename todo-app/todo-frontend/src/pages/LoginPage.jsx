import { useContext, useEffect, useState } from 'react';
import '../styles/loginStyle.css';
import {Link, useNavigate} from 'react-router';
import {AuthContext} from '../store/authContext';

const LoginPage = () => {
  const ctx = useContext(AuthContext)
  const navigation = useNavigate();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const [signup, setSignup] = useState(false);
 

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleShowPassword = () => {
    setShowPassword(!showPassword);
  };
  const handlSignupClick = () => {
    setSignup(!signup);
  }
 
  const handleLogin = () => {
    console.log("first")
    ctx.login(username)
  };
  useEffect(()=>{
    if(ctx.user){
      navigation('/')
      
    }
  }, [ctx])

  if(ctx.user){
    return null
  }else{
    return (
      <div className='wrap-center'>
        <div className="login-container">
         <div className="login-form">
           <h2>Welcome {!signup && "Back"}!</h2>
           
           <p className="login-tagline">Sign {signup ? "up" : 'in'} to continue your journey</p>
           <form onSubmit={handleLogin}>
             <div className="form-group">
               <label htmlFor="username">Username</label>
               <input
                 
                 id="username"
                 type="text"
                 value={username}
                 onChange={handleUsernameChange}
                 placeholder="Enter your username"
                 required
               />
             </div>
             <div className="form-group">
               <label htmlFor="password">Password</label>
               <div className="password-wrapper">
                 <input
                 
                   id="password"
                   type={showPassword ? 'text' : 'password'}
                   value={password}
                   onChange={handlePasswordChange}
                   placeholder="Enter your password"
                   required
                 />
              
                 <button
                   type="button"
                   className="show-password"
                   onClick={handleShowPassword}
                 >
                   {showPassword ? 'Hide' : 'Show'}
                 </button>
               </div>
             </div>
             <button type="submit" className="login-button" >
             {!signup ? "Login" : "Signup"}
             </button>
           </form>
           <p className="signup-link">
            {signup ? "Already have an account" : " Don't have an account?"} <span onClick={handlSignupClick}>{signup ? "Login" : "Signup"}</span>
           </p>
         </div>
       </div>
      </div>
     );
  }

  
};

export default LoginPage;
