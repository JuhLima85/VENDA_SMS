import logo from '../../assets/img/logo.svg'

import './styles.css'

function Header() {
    return (
        <header>
            <div className="listavendas-logo-container">
                <img src={logo} alt="listavendas" />
                    <h1>Lista de Vendas</h1>
                    <p>Desenvolvido por
                        <a href="https://www.instagram.com/juhamil/">@juhamil</a>
                    </p>
                    <p>Aluna do
                        <a href="https://www.instagram.com/devsuperior.ig/">@devsuperior.ig</a>
                    </p>
            </div>
        </header>

    )
}

export default Header