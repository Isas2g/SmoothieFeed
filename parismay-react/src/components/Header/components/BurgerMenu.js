import React from 'react';

import './BurgerMenu.scss';

const BurgerMenu = () => {

    return (
        <div>
            <div className="burger">
                <span></span>
            </div>
            <div className="menu"></div>
        </div>
    );

};

export default React.memo(BurgerMenu);