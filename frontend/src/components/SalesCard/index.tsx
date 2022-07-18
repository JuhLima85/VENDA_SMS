import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import NotificationButtom from '../NotificationButton';
import './styles.css';

function SalesCard() {
const min = new Date(new Date().setDate(new Date().getDate() - 365));
const max = new Date;

    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    return (
        <div className="listavendas-card">
            <h2 className="desmeta-sales-title">Vendas</h2>
            <div>
                <div className="listavendas-form-control-container">
                    <DatePicker
                        selected={minDate}
                        onChange={(date: Date) => setMinDate(date)}
                        className="listavendas-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
                <div className="listavendas-form-control-container">
                    <DatePicker
                        selected={maxDate}
                        onChange={(date: Date) => setMaxDate(date)}
                        className="listavendas-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
            </div>

            <div>
                <table className="listavendas-sales-table">
                    <thead>
                        <tr>
                            <th className="shows992">ID</th>
                            <th className="shows576">Data</th>
                            <th>Vendedor</th>
                            <th className="shows992">Visitas</th>
                            <th className="shows992">Vendas</th>
                            <th>total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td className="shows992">#341</td>
                            <td className="shows576">16/07/2022</td>
                            <td>Joel AnaKin</td>
                            <td className="shows992">15</td>
                            <td className="shows992">11</td>
                            <td>R$ 55300.00</td>
                            <td>
                                <div className="listavendas-red-btn">
                                    <NotificationButtom />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="shows992">#341</td>
                            <td className="shows576">16/07/2022</td>
                            <td>Joel AnaKin</td>
                            <td className="shows992">15</td>
                            <td className="shows992">11</td>
                            <td>R$ 55300.00</td>
                            <td>
                                <div className="listavendas-red-btn">
                                    <NotificationButtom />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="shows992">#341</td>
                            <td className="shows576">16/07/2022</td>
                            <td>Joel AnaKin</td>
                            <td className="shows992">15</td>
                            <td className="shows992">11</td>
                            <td>R$ 55300.00</td>
                            <td>
                                <div className="listavendas-red-btn">
                                    <NotificationButtom />
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

        </div>
    )
}

export default SalesCard;