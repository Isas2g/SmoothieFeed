import React from 'react';

const OpportunitiesBlock = () => {
    return (
        <div className="opportunities">
            <h2 className="opportunities__title"></h2>
            <div className="opportunities__opportunity opportunity">
                <div className="opportunity__item">
                    <div className="opportunity__icon"></div>
                    <h4 className="opportunity__description"></h4> // TODO: Сделать компонентом opportunity? Таких блоков должно быть 3
                </div>
            </div>
        </div>
    );
};

export default OpportunitiesBlock;