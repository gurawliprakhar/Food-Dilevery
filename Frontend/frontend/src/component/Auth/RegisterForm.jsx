import { Button, MenuItem, Select, TextField, Typography } from "@mui/material";
import { Field, Form, Formik } from "formik";
import React from "react";
import { useNavigate, useDispatch } from "react-router-dom";
import { RegisterUser } from "../state/Authentication/Action";

const intitalValues = {
  fullname: "",
  email: "",
  password: "",
  role: "ROLE_CUSTOMER",
};

function RegisterForm() {
  const navigate = useNavigate();
  const dispatch = useDispatch()
  
  const handleSubmit = (values) => {
    console.log("form value", values);
    dispatchEvent(RegisterUser({userData:values,navigate}))
  };

  return (
    <div>
      <Typography variant="h5" className="text-center">
        Register
      </Typography>
      <Formik onSubmit={handleSubmit} intitalValues={intitalValues}>
        <Form>
          <Field
            as={TextField}
            name="fullName"
            label="full name"
            fullWidth
            variant="outlined"
            margin="normal"
          />
          <Field
            as={TextField}
            name="password"
            label="password"
            fullWidth
            variant="outlined"
            margin="normal"
            type="password"
          />
          <Field
            fullWidth
            margin="normal"
            as={Select}
            labelId="role-simple-select-label"
            id="demo-simple-select"
            name="role"
            //value={age}
            // onChange={handleChange}
          >
            <MenuItem value={"ROLE_CUSTOMER"}>Customer</MenuItem>
            <MenuItem value={"ROLE_RESTAURANT_OWNER"}>
              Restaurant Owner
            </MenuItem>
          </Field>
          <Button
            sx={{ mt: 2, padding: "1" }}
            fullWidth
            type="submit"
            variant="contained"
          ></Button>
        </Form>
      </Formik>
      <Typography variant="body2" align="center" sx={{ mt: 3 }}>
        if have an already account?
        <Button size="small" onCLick={() => navigate("account/login")}>
          Login
        </Button>
      </Typography>
    </div>
  );
}

export default RegisterForm;
