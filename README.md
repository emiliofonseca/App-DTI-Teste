# App-DTI-Teste

Aplicativo desenvolvido para buscar dados da [API](https://github.com/emiliofonseca/DTI-Test)

Para que o aplicativo se conecte corretamente, é preciso modificar o arquivo `build.gradle`, trocando o IP que está configurado [nessa linha](https://github.com/emiliofonseca/App-DTI-Teste/blob/master/app/build.gradle#L23).

- Caso esteja executando em um emulador, basta trocar o IP para `10.0.2.2`.
- Caso esteja executando em um dispositivo, é necessário que ele esteja na mesma rede que o computador que está servindo a API. Por fim, basta trocar o IP para o IP da máquina.
