import './App.css'
import LoginPage from './pages/LoginPage'
import {Navigate, Route, Routes, useNavigate} from 'react-router'
import TodoPage from './pages/TodoPage'
import PageNotFound from './pages/PageNotFound'
import {useEffect} from 'react'

function App() {
  const loginUser = localStorage.getItem('loginUser')
  const navigation = useNavigate()
  useEffect(()=>{
   
    if (!loginUser) {
      navigation('/login')
    }
  }, [])
 
  

  return (
    <Routes>
      <Route path="/login" element={<LoginPage />} />
      <Route path="/" element={<TodoPage />} />
      <Route path="/404" element={<PageNotFound />} />
      <Route path="*" element={<Navigate replace to="/404" />} />
    </Routes>
  )
}

export default App
