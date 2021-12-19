import React            from 'react';
import Header           from '@components/Header/Header';
import FormUserPrograms from '@components/FormUserPrograms';
import MainPrograms     from '@components/MainPrograms';
import DetoxPrograms from "@components/DetoxPrograms";

import "./Programs.scss";
import DetoxOnboarding from "@pages/Programs/components/DetoxOnboarding";
import social from "@assets/images/bg-social.png";

const Programs = () => {
	// TODO: Переделать полностью страницу Programs (Сделать вывод программ через компонент DetoxCard)
	return <main className="main opacity">
			<DetoxOnboarding />
			<img className="preview__image preview__image_social" src={social} alt="#"/>
			<div className="container">
				<div className="main__programs programs">
					<h1 className="programs__title main-title">Выбрать существующую программу</h1>
					<DetoxPrograms/>
				</div>
			</div>
			<hr className="main__hr-line hr-line"/>
			<FormUserPrograms/>
	</main>;
};

export default React.memo(Programs);