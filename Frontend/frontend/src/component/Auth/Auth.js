import { Box, Modal } from '@mui/material';
import React from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { style } from '../Cart/Cart';

export const Auth = () => {
    const location = useLocation();
    const navigate = useNavigate();
    const handleOnClose=()=> {
        navigate("")
    }
    return (
        <>
            <Modal onCLose={handleOnClose} open={
               location.pathname === "/account/register"
            || location.pathname==="account/login"
            
            }>
              
            <Box sx={style}>
             hello
            </Box>
            </Modal>
        </>
    );
};