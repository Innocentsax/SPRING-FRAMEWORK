import logo from "./logo.svg";
import "./App.css";
import Navbar from "./component/Navbar";
import { CssBaseline, ThemeProvider } from "@mui/material";
import { darkTheme } from "./Theme/DarkTheme";
import Home from "./component/Home/Home";

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <Navbar />
      <Home />
    </ThemeProvider>
  );
}

export default App;
