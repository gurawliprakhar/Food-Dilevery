import { Box, Modal } from '@mui/material';
import React from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export const Auth = () => {
    const location = useLocation();
    const navigate = useNavigate();

    return (
        <>
            <Modal open={location.pathname === "/account/register"
            || location.pathname==="account/login"
            }>
                
            <Box>
                
            </Box>
            </Modal>
        </>
    );
};
