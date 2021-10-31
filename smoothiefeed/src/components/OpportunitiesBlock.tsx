import React from 'react';

// TODO: Сделать компонентом opportunity? Таких блоков должно быть 3

const OpportunitiesBlock = () => {
    return (
        <div className="opportunities">
            <h2 className="opportunities__title"></h2>
            <div className="opportunities__opportunity opportunity">
                <div className="opportunity__item">
                    <div className="opportunity__icon"></div>
                    <h4 className="opportunity__description"></h4>
                </div>
            </div>
        </div>
    );
};

export default OpportunitiesBlock;