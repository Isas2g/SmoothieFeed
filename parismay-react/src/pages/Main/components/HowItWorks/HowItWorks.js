import * as React from 'react';
import {Link}     from 'react-router-dom';

import Step from './components/Step';

import signUp   from '@assets/images/sign-up.svg';
import detox    from '@assets/images/detox.svg';
import check    from '@assets/images/check.svg';
import smoothie from '@assets/images/bg-smoothie.png';

import {routes} from '@configs/routes';

import './HowItWorks.scss';

const HowItWorks = () => {
	const steps = React.useMemo(() => [
		{
			title: 'Регистрация/вход',
			description: 'Зарегистрируйтесь или выполните вход через соцсети.',
			image: signUp,
		},
		{
			title: 'Подбор подходящей программы digital-детокса',
			description: 'Ограничьте время и количество постов в день из выбранных соцсетей.',
			image: detox,
		},
		{
			title: 'Просмотр постов',
			description: 'Просматривайте посты и отслеживайте свой прогресс!',
			image: check,
		},
	], []);
	
	return <div className="container-bg-image-smoothie-social">
		<div className="container">
			<div className="main__how-it-works how-it-works">
				<h2 className="how-it-works__title title">Как это работает?</h2>
				<div className="how-it-works__blocks">
					{steps.map((el, key) => {
						return <Step key={key} id={key + 1} el={el}/>;
					})}
				</div>
			</div>
		</div>
	</div>
};

export default React.memo(HowItWorks);