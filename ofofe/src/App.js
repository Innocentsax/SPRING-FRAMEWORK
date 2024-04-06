import "./App.css";
import Navbar from "./component/Navbar";
import { CssBaseline, ThemeProvider } from "@mui/material";
import { darkTheme } from "./Theme/DarkTheme";
import Home from "./component/Home/Home";
import RestaurantDetails from "./component/Restaurant/RestaurantDetails";
import Cart from "./component/Cart/Cart";
import Profile from "./component/Profile/Profile";
import CustomerRoute from "./Routers/CustomerRoute";
import { useDispatch, useSelector } from "react-redux";
import { getUser } from "./component/State/Authentication/Action";
import { useEffect } from "react";

function App() {
  const dispatch = useDispatch();
  const jwt = localStorage.getItem("jwt");
  const { auth } = useSelector((store) => store);

  useEffect(() => {
    dispatch(getUser(auth.jwt || jwt));
  }, [auth.jwt]);

  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <CustomerRoute />
    </ThemeProvider>
  );
}

export default App;

// import "./App.css";
// import Navbar from "./component/Navbar";
// import { CssBaseline, ThemeProvider } from "@mui/material";
// import { darkTheme } from "./Theme/DarkTheme";
// import Home from "./component/Home/Home";
// import RestaurantDetails from "./component/Restaurant/RestaurantDetails";
// import Cart from "./component/Cart/Cart";
// import Profile from "./component/Profile/Profile";
// import CustomerRoute from "./Routers/CustomerRoute";
// import { useDispatch, useSelector } from "react-redux";
// import { getUser } from "./component/State/Authentication/Action";
// import { useEffect } from "react";

// function App() {
//   const dispatch = useDispatch(); // Corrected: Added parentheses to useDispatch

//   const jwt = localStorage.getItem("jwt");
//   const { auth } = useSelector((store) => store);

//   useEffect(() => {
//     dispatch(getUser(auth.jwt || jwt));
//   }, [auth.jwt, dispatch]); // Corrected: Added dispatch as a dependency

//   return (
//     <ThemeProvider theme={darkTheme}>
//       <CssBaseline />
//       <CustomerRoute />
//     </ThemeProvider>
//   );
// }

// export default App;
