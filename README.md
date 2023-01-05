# back-end-transfer
<h2> Back-end (https://github.com/IsadoraPalhoti/back-end-transfer) </h2>
<h3> Tecnologias usadas no Back-end </h3>

- `Spring Boot`
- `JDK 11`
- `Apache Maven`
- `H2`
- `Lombok`

<h3> Como Rodar o Projeto </h3>

- `Baixar o projeto e subir localmente na branch master`
- `Porta utilizada: http://localhost:8080`

<h3> Detalhe do Projeto </h3>
<p>O backend foi desenvolvido utilizando quatro camadas</p>

- `Resourse: onde fica os endpoints `
- `Repository: onde fica a camada com o JPA`
- `Factory: onde está a lógica do projeto`
- `Service: que fica responsável em mandar salvar os dados`

<p>Endpoints</p>

- `GET: http://localhost:8080/transfer`
- `POST: http://localhost:8080/transfer`

<p> JSON para teste no PostMan </p>
<p>{
      <p>"accountOring": "xxxxxx",</p>
      <p>"accountDestin": "xxxxx",</p>
      <p>"velue": 100.00,</p>
      <p>"dateScheduled": "13/11/2022",</p>
    <p>"period": "A"</p>
} </p>

<h2> Front-end (https://github.com/IsadoraPalhoti/front-end-transfer)</h2>
<h3> Tecnologias usadas no Front-end </h3>

- `Angular 12.05`
- `Node 14.17.1`
- `Bootstrap`
- `scss`

<h3> Como Rodar o Projeto </h3>

- `Baixar o projeto e subir localmente na branch master`
- `Porta utilizada:http://localhost:4200/rate`
<p> Imagem das Telas do projeto </p>

![image](https://user-images.githubusercontent.com/43323404/201694619-88daaac9-88ab-4447-9ab1-e45387ae68fc.png)
![image](https://user-images.githubusercontent.com/43323404/201694739-603e1e02-82d0-4369-879d-caf6e8cff0e1.png)
