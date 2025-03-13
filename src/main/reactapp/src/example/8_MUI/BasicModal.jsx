import { Modal, Typography } from "@mui/material";
import { useState } from "react";


export default function BasicModal(props) {

    const [open, setOpen] = useState(false);

    return (
        <>
            <Modal
                aria-labelledby="modal-title"
                aria-describedby="modal-desc"
                open={open}
                onClose={() => setOpen(false)}
                sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}
            >
                <Sheet variant="outlined" sx={{ maxWidth: 500, borderRadius: 'md', p: 3, boxShadow: 'lg' }}>
                    <ModalClose variant="plain" sx={{ m: 1 }} />
                    <Typography component="h2" id="modal-title" level="h4" textColor="inherit" sx={{ fontWeight: 'lg', mb: 1 }}>
                        안녕하세요
                    </Typography>
                    <Typography id="modal-desc" textColor="text.tertiary">
                        회원가입 축하드립니다
                    </Typography>
                </Sheet>
            </Modal>
        </>
    );
}