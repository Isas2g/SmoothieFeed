import React from 'react';
import LearnButton from "./UI/LearnButton";

const PreviewBLock = () => {
    return (
        <div className="preview">
            <h1 className="preview__title"></h1>
            <h3 className="preview__description"></h3>
            <LearnButton />
        </div>
    );
};

export default PreviewBLock;