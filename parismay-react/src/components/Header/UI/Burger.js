import React, {useState} from 'react';

import './Burger.scss';

const Burger = ({active, setActive}) => {

    return (
        <div onClick={() => setActive(!active)} className="burger__button">
            <span />
        </div>
    );

};

export default React.memo(Burger);