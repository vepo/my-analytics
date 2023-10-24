# Arquitetura Hexagonal

## Roteiro

- [ ] O que é?
- [ ] Quando usar?
- [ ] Como implementar?
- [ ] Como implementar usando Jakarta EE?

## O que é?

Original: https://alistair.cockburn.us/hexagonal-architecture/


### Intento

* Isolar o código de negócio para ser testado
* Aplicação é acessada por drivers através de portas e adaptadores.

### Motivação

* Evitar que código de negócios vaze para código da interface de usuário.
* Possibilitar que especialista de negócios crie testes automatizados sem a GUI
* Possibilitar o uso "_headless_"

### Natureza

* Aplicações são naturalmente divididas em lados: "internos"/"externos", "esquerda"/"direita", "acima"/"abaixo".
* Sistemas podem ter várias dimensões de comunicação
* Portas são meios lógico de acesso ao código de negócio
* Adaptadores são implementações de protocolos/meios de acesso as portas
* Drivers são o componente em execução que acessa a porta através adaptadores


<!-- https://excalidraw.com/#json=Ua2ndN5wICR8DVK-SaFjx,rxJ5isJlCtYJ9OwPQOTorw -->

![](/resources/hexagonal-prod.png)

<!-- https://excalidraw.com/#json=UeRIRDoRwmSlYVh867C9r,fKWHvhVea8BdS9cjpLbbnA -->

![](/resources/hexagonal-dev.png)

## Quando usar?

* Testes de aplicações
* Evitar carregar dependência através de Mocks

## Como implementar?

* https://github.com/natanielpaiva/arquitetura-hexagonal
* https://github.com/thombergs/buckpal

## Como implementar usando Jakarta EE?