import React from 'react';
import FormRegistration from "@pages/Registration/components/FormRegistration";

const Registration = () => {
    return (
        <main className="main main-entry opacity container">
            <div className="form-block">
                <h1 className="form-block__title">Регистрация</h1>
                <FormRegistration />
            </div>

        </main>
    );
};

export default React.memo(Registration);