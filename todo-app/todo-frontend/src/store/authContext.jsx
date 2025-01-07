import {createContext, useEffect, useState} from "react";

export const AuthContext = createContext(
    {
        user: null,
        login: () => {},
        logout: () => {}
    }
);


const AuthProvider = (props) => {
    const loginUser = localStorage.getItem('loginUser')

    
    const [user, setUser] = useState("");

    useEffect(()=>{
        if(loginUser){
            setUser(loginUser)
        }
    },[])
    const login = (username) => {
        console.log("first")
        setUser(username);
        localStorage.setItem('loginUser', username)
    }
    const logout = () => {
        localStorage.removeItem('loginUser')
        setUser(null);
    }
    return (
        <AuthContext.Provider value={{user, login, logout}}>
            {props.children}
        </AuthContext.Provider>
    );
}
export default AuthProvider;