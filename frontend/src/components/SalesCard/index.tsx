import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Sale } from "../../models/sale";
import { BASE_URL } from "../../utils/request";
import NotificationButton from "../NotificationButton";
import './styles.css';

function SalesCard() {
    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date;

    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    const [sales, setSales] = useState<Sale[]>([]);

    useEffect(() => {

        const dmin = minDate.toISOString().slice(0, 10);
        const dmax = maxDate.toISOString().slice(0, 10);

        axios.get(`${BASE_URL}/vendas/v1?minDate=${dmin}&maxDate=${dmax}`)
            .then(response => {
                setSales(response.data.content);

            });
    }, [minDate, maxDate]);

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
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {sales.map(sale => {
                            return (
                                <tr key={sale.id}>
                                    <td className="shows992">{sale.id}</td>
                                    <td className="shows576">{new Date(sale.data).toLocaleDateString()}</td>
                                    <td>{sale.vendedor}</td>
                                    <td className="shows992">{sale.visitas}</td>
                                    <td className="shows992">{sale.venda}</td>
                                    <td>{sale.total.toFixed(2)}</td>
                                    <td>
                                        <div className="listavendas-red-btn-container">
                                            <NotificationButton saleId={sale.id} />
                                        </div>
                                    </td>
                                </tr>

                            )
                        })}
                    </tbody>
                </table>
            </div>

        </div>
    )
}

export default SalesCard;