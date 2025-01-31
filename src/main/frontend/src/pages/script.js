document.addEventListener("DOMContentLoaded", function () {
    const carrosTableBody = document.querySelector("#carrosTable tbody");
    const motosTableBody = document.querySelector("#motosTable tbody");

    const formularioCarro = document.getElementById("formularioCarro");
    const formularioMoto = document.getElementById("formularioMoto");

    let carroIdEditando = null;
    let motoIdEditando = null;

    // Carregar Carros
    function carregarCarros() {
        fetch("http://localhost:8080/carros")
            .then(response => response.json())
            .then(carros => {
                carrosTableBody.innerHTML = '';
                carros.forEach(carro => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${carro.id}</td>
                        <td>${carro.modelo}</td>
                        <td>${carro.fabricante}</td>
                        <td>${carro.ano}</td>
                        <td>${carro.preco}</td>
                        <td>${carro.tipoCombustivel}</td>
                        <td>
                            <button class="editarCarro" data-id="${carro.id}">Editar</button>
                            <button class="excluirCarro" data-id="${carro.id}">Excluir</button>
                        </td>
                    `;
                    carrosTableBody.appendChild(row);
                });

                adicionarEventosAcoes(); // Adiciona os eventos de editar e excluir
            });
    }

    // Carregar Motos
    function carregarMotos() {
        fetch("http://localhost:8080/motos")
            .then(response => response.json())
            .then(motos => {
                motosTableBody.innerHTML = '';
                motos.forEach(moto => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${moto.id}</td>
                        <td>${moto.modelo}</td>
                        <td>${moto.fabricante}</td>
                        <td>${moto.ano}</td>
                        <td>${moto.preco}</td>
                        <td>${moto.cilindrada}</td>
                        <td>
                            <button class="editarMoto" data-id="${moto.id}">Editar</button>
                            <button class="excluirMoto" data-id="${moto.id}">Excluir</button>
                        </td>
                    `;
                    motosTableBody.appendChild(row);
                });

                adicionarEventosAcoes(); // Adiciona os eventos de editar e excluir
            });
    }

    // Adicionar Carro
    function adicionarCarro() {
        const carro = {
            modelo: document.getElementById("modeloCarro").value,
            fabricante: document.getElementById("fabricanteCarro").value,
            ano: parseInt(document.getElementById("anoCarro").value),
            preco: parseFloat(document.getElementById("precoCarro").value),
            quantidadePortas: parseInt(document.getElementById("quantidadePortasCarro").value),
            tipoCombustivel: document.getElementById("tipoCombustivelCarro").value
        };

        fetch("http://localhost:8080/carros", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(carro)
        })
        .then(response => response.json())
        .then(() => {
            carregarCarros();
            cancelarFormularioCarro();
        });
    }

    // Adicionar Moto
    function adicionarMoto() {
        const moto = {
            modelo: document.getElementById("modeloMoto").value,
            fabricante: document.getElementById("fabricanteMoto").value,
            ano: parseInt(document.getElementById("anoMoto").value),
            preco: parseFloat(document.getElementById("precoMoto").value),
            cilindrada: parseInt(document.getElementById("cilindradaMoto").value)
        };

        fetch("http://localhost:8080/motos", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(moto)
        })
        .then(response => response.json())
        .then(() => {
            carregarMotos();
            cancelarFormularioMoto();
        });
    }

    // Editar Carro
    function editarCarro(id) {
        console.log('a');
        fetch(`http://localhost:8080/carros/${id}`)
            .then(response => response.json())
            .then(carro => {
                carroIdEditando = carro.id;
                document.getElementById("modeloCarro").value = carro.modelo;
                document.getElementById("fabricanteCarro").value = carro.fabricante;
                document.getElementById("anoCarro").value = carro.ano;
                document.getElementById("precoCarro").value = carro.preco;
                document.getElementById("quantidadePortasCarro").value = carro.quantidadePortas;
                document.getElementById("tipoCombustivelCarro").value = carro.tipoCombustivel;
                formularioCarro.style.display = 'block';
            });
    }

    // Editar Moto
    function editarMoto(id) {
        fetch(`http://localhost:8080/motos/${id}`)
            .then(response => response.json())
            .then(moto => {
                motoIdEditando = moto.id;
                document.getElementById("modeloMoto").value = moto.modelo;
                document.getElementById("fabricanteMoto").value = moto.fabricante;
                document.getElementById("anoMoto").value = moto.ano;
                document.getElementById("precoMoto").value = moto.preco;
                document.getElementById("cilindradaMoto").value = moto.cilindrada;
                formularioMoto.style.display = 'block';
            });
    }

    // Excluir Carro
    function excluirCarro(id) {
        fetch(`http://localhost:8080/carros/${id}`, {
            method: "DELETE"
        })
        .then(() => carregarCarros());
    }

    // Excluir Moto
    function excluirMoto(id) {
        fetch(`http://localhost:8080/motos/${id}`, {
            method: "DELETE"
        })
        .then(() => carregarMotos());
    }

    // Cancelar Formulário de Carro
    function cancelarFormularioCarro() {
        formularioCarro.style.display = 'none';
        carroIdEditando = null;
    }

    // Cancelar Formulário de Moto
    function cancelarFormularioMoto() {
        formularioMoto.style.display = 'none';
        motoIdEditando = null;
    }

    // Função para adicionar os eventos de ação (Editar/Excluir)
    function adicionarEventosAcoes() {
        document.querySelectorAll('.editarCarro').forEach(btn => {
            btn.addEventListener('click', function() {
                editarCarro(btn.getAttribute('data-id'));
            });
        });

        document.querySelectorAll('.excluirCarro').forEach(btn => {
            btn.addEventListener('click', function() {
                excluirCarro(btn.getAttribute('data-id'));
            });
        });

        document.querySelectorAll('.editarMoto').forEach(btn => {
            btn.addEventListener('click', function() {
                editarMoto(btn.getAttribute('data-id'));
            });
        });

        document.querySelectorAll('.excluirMoto').forEach(btn => {
            btn.addEventListener('click', function() {
                excluirMoto(btn.getAttribute('data-id'));
            });
        });
    }

    // Inicializar Carros e Motos
    document.getElementById("adicionarCarroBtn").addEventListener("click", function () {
        formularioCarro.style.display = 'block';
    });

    document.getElementById("adicionarMotoBtn").addEventListener("click", function () {
        formularioMoto.style.display = 'block';
    });

    document.getElementById("salvarCarroBtn").addEventListener("click", function () {
        if (carroIdEditando) {
            // Editar Carro
            const carro = {
                modelo: document.getElementById("modeloCarro").value,
                fabricante: document.getElementById("fabricanteCarro").value,
                ano: parseInt(document.getElementById("anoCarro").value),
                preco: parseFloat(document.getElementById("precoCarro").value),
                quantidadePortas: parseInt(document.getElementById("quantidadePortasCarro").value),
                tipoCombustivel: document.getElementById("tipoCombustivelCarro").value
            };
    
            fetch(`http://localhost:8080/carros/${carroIdEditando}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(carro)
            })
            .then(response => {
                console.log("Tipo de resposta:", response);  // Adicione isso para depurar a resposta
                if (!response.ok) {
                    throw new Error(`Erro na resposta: ${response.status} ${response.statusText}`);
                }
                return response.text();
            })
            .then(() => {
                carregarCarros();
                cancelarFormularioCarro();
            });
        } else {
            adicionarCarro();
        }
    });
    
    document.getElementById("salvarMotoBtn").addEventListener("click", function () {
        if (motoIdEditando) {
            // Editar Moto
            const moto = {
                modelo: document.getElementById("modeloMoto").value,
                fabricante: document.getElementById("fabricanteMoto").value,
                ano: parseInt(document.getElementById("anoMoto").value),
                preco: parseFloat(document.getElementById("precoMoto").value),
                cilindrada: parseInt(document.getElementById("cilindradaMoto").value)
            };
    
            fetch(`http://localhost:8080/motos/${motoIdEditando}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(moto)
            })
            .then(response => {
                console.log("Tipo de resposta:", response);  // Adicione isso para depurar a resposta
                if (!response.ok) {
                    throw new Error(`Erro na resposta: ${response.status} ${response.statusText}`);
                }
                return response.text();
            })
            .then(() => {
                carregarMotos();
                cancelarFormularioMoto();
            });
        } else {
            adicionarMoto();
        }
    });
    

    document.getElementById("cancelarCarroBtn").addEventListener("click", cancelarFormularioCarro);
    document.getElementById("cancelarMotoBtn").addEventListener("click", cancelarFormularioMoto);

    carregarCarros();
    carregarMotos();
});
