import * as React       from 'react';
import FormEntry from "@pages/Auth/components/FormEntry/FormEntry";
import { Link } from "react-router-dom";

import "./Auth.scss";
import social from "@assets/images/bg-social.png";
import vk from "@assets/images/social-vk.svg";
import instagram from "@assets/images/social-instagram.svg";
import facebook from "@assets/images/social-facebook.svg";
import twitter from "@assets/images/social-twitter.svg";
import AuthOnboarding from "@pages/Auth/components/AuthOnboarding";

const Auth = ({display}) => {

	return <main className="main-entry container">
			<AuthOnboarding display={display} />
			<img className="main-entry__image" src={social} alt="#"/>
			<div className="main-entry__entry entry">
				<h1 className="entry__title">Войти на сайт</h1>
				<FormEntry/>
				<hr className="hr-line"/>
				<div className="entry__social social">
					<h2 className="social__title">или</h2>
					<div className="social__icons">
						<Link className="social__link">
							<img className="social__icon" src={vk} alt="#"/>
						</Link>
						<Link className="social__link">
							<img className="social__icon" src={instagram} alt="#"/>
						</Link>
						<Link className="social__link">
							<img className="social__icon" src={facebook} alt="#"/>
						</Link>
						<Link className="social__link">
							<img className="social__icon" src={twitter} alt="#"/>
						</Link>
					</div>
				</div>
			</div>
		</main>;
};

export default React.memo(Auth);