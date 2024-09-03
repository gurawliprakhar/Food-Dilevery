import { CssBaseline, ThemeProvider } from "@mui/material";
import "./App.css";
import { Navbar } from "./component/Navbar/Navbar";

import darkTheme from './Theme/DarkTheme'; 
import Home from "./component/Home/Home";
import RestaurantDetails from "./component/Restaurant/RestaurantDetails";
import Cart from "./component/Cart/Cart";
import Profile from "./component/Profile/Profile";
import { CustomerRoute } from "./Routers/CustomerRoute";
import { Auth } from "./component/Auth/Auth";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux"
import { getUser } from "./component/state/Authentication/Action";

function App() {
  const dispatch = useDispatch()
  const jwt = localStorage.getItem("jwt")
  const {auth}=useSelector(store=>store)
  useEffect(()=>{
     dispatch(getUser(auth.jwt || jwt))
  }, [auth.jwt])

  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline/>
      <CustomerRoute/>
    </ThemeProvider>
  );
}

export default App;
