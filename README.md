# desafio1conversor

Implementação em Java de um conversor de moedas que busca a cotação em tempo real em uma API.

O projeto tenta fazer uma mini implementação de Clean Architecure usando as camadas de Domain (Entities), Use Cases, External Services e App. 

Usando a ideia da separação dos detalhes do código, considerando que a implementação da busca do valor atual da cotação é um detalhe, foi criada a interface `CotacaoService` na camada de Domain que é implementada por um campo na entidade `Dinheiro` para buscar a cotação atual entre duas moedas. Esse campo é iniciado através do construtor de `Dinheiro`.
