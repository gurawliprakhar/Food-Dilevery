import { Button, FormControl, InputLabel, MenuItem, Select, TextField, Typography } from "@mui/material";
import { Field, Form, Formik } from "formik";
import React from "react";
import { useNavigate } from "react-router-dom";

const intitalValues = {
  fullname: "",
  email: "",
  password: "",
  role: "",
};

function RegisterForm() {
  const navigate = useNavigate();
  const handleSubmit = () => {};

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
          />
          <FormControl fullWidth>
            <InputLabel id="demo-simple-select-label">Role</InputLabel>
            <Field
            as={Select}
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              //value={age}
              label="Age"
             // onChange={handleChange}
            >
              <MenuItem value={"ROLE_CUSTOMER"}>Customer</MenuItem>
              <MenuItem value={"ROLE_RESTAURANT_OWNER"}>Restaurant Owner</MenuItem>
            </Field>
          </FormControl>
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
          register
        </Button>
      </Typography>
    </div>
  );
}

export default RegisterForm;
