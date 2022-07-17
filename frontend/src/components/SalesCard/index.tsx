import NotificationButtom from '../NotificationButton'
import './styles.css'

function SalesCard() {
    return (
        <div className="listavendas-card">
            <h2 className="desmeta-sales-title">Vendas</h2>
            <div>
                <div className="listavendas-form-control-container">
                    <input className="listavendas-form-control" type="text" />
                </div>
                <div className="listavendas-form-control-container">
                    <input className="listavendas-form-control" type="text" />
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

export default SalesCard