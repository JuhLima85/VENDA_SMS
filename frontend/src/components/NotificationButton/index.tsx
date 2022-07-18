import icon from '../../assets/img/notification-icon.svg';
import './styles.css';

function NotificationButtom() {
    return (
        <div className= "listavendas-red-btn">
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButtom;