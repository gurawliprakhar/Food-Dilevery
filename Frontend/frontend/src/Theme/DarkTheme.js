const { createTheme } = require("@mui/material");

const darkTheme = createTheme({
  palette: {
    mode: "dark",
    primary: {
      main: "#e91e63"
    },
    secondary: {
      main: "#5A20CB"
    },
    background: {
      main:"0D0D0D",
      default: "#0D0D0D",
      paper: "#0D0D0D"
    },
    textColor: {
      main: "#111111" 
    },
    black: {
      main: "#0D0D0D"
    }
  }
});

module.exports = darkTheme;
