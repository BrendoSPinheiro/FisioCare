# FisioCare Clinic

## Introdução e Motivação
Em um mundo cada vez mais digital, a otimização de processos em clínicas de saúde tornou-se não apenas um desejo, mas 
uma necessidade. A FisioCare, uma clínica de fisioterapia inovadora, enfrenta o desafio de gerenciar manualmente as 
fichas de pacientes, uma prática que, embora tradicional, apresenta ineficiências e riscos significativos. A ausência de
um sistema automatizado resulta em maior tempo de gestão, risco de perda ou danos às informações físicas e dificuldade
em acessar rapidamente os dados dos pacientes. Este projeto nasce da necessidade de transformar esses processos manuais
em um sistema digital integrado, visando melhorar a eficiência operacional e a qualidade do atendimento ao paciente.

## Descrição
O FisioCare é um sistema desenvolvido para automatizar e simplificar a gestão de pacientes em clínicas de fisioterapia.
Com funcionalidades focadas em eficiência e organização, o sistema permite que recepcionistas realizem o pré-cadastro de
pacientes e criem fichas de tratamento. Estas fichas são posteriormente gerenciadas pelos fisioterapeutas, facilitando o
acompanhamento e a administração dos tratamentos.

Essa solução busca otimizar o fluxo de trabalho dentro da clínica, reduzindo a carga administrativa e permitindo que os
profissionais de saúde concentrem-se mais no atendimento ao paciente. O FisioCare é projetado para ser uma ferramenta 
intuitiva e fácil de usar, contribuindo para uma gestão mais eficiente e organizada das informações dos pacientes.

## Demonstração da Aplicação
- **Link para Demo**: _[Adicionar link quando disponível]_
- **Screenshots e Vídeos**: _[Adicionar imagens e vídeos da aplicação]_

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- PostgreSQL
- Flyway
- Docker
- GitHub Actions

## Arquitetura do Sistema
- _[Descreva a arquitetura do sistema, incluindo como as diferentes tecnologias interagem entre si]_

## Banco de Dados
### Tabelas
- **tb_patient_records**: Fichas dos pacientes.
- **tb_users**: Dados dos usuários do sistema.
- **tb_medias**: Mídias associadas às fichas dos pacientes.
### Tipos
- **gender_enum**: Enumerador de opções de gêneros
- **patient_status_enum**: Enumerador de status dos pacientes
### Diagrama ERD
![Diagrama Entidade Relacionamento](/doc/fisiocare_db_diagram.png.png)

## Funcionalidades Principais
- Pré-cadastro de pacientes por recepcionistas.
- Gerenciamento de fichas de pacientes por fisioterapeutas.
- Upload e gestão de mídias associadas às fichas.

## Regras de Negócio

### Pré-Cadastro de Pacientes (Recepcionistas)
- Realização do pré-cadastro de novos pacientes criando uma ficha (`patient_record`) para cada paciente, contendo informações pessoais.
- As fichas iniciam com o status `pending`.

### Gestão de Fichas (Fisioterapeutas)
- Fisioterapeutas podem assumir o atendimento de pacientes com fichas `pending`.
- Ao assumir uma ficha, o status muda para `in_treatment`.
- Apenas o fisioterapeuta vinculado à ficha pode realizar alterações.
- Um fisioterapeuta pode atender múltiplos pacientes, mas um paciente só pode ter um fisioterapeuta por vez.

### Alteração de Status da Ficha
- Fichas iniciam com status `pending` e podem mudar para `in_treatment` ou `cancelled`.
- De `in_treatment`, podem mudar para `completed`, `cancelled` ou `on_hold`.
- De `on_hold`, podem mudar para `in_treatment` ou `cancelled`.
- Status `completed` ou `cancelled` são finais e imutáveis.

### Consulta de Fichas (Recepcionistas e Fisioterapeutas)
- Recepcionistas podem verificar se um paciente já possui ficha e fazer pré-cadastros.
- Fisioterapeutas podem consultar e gerenciar as fichas dos pacientes que atendem.
- Fisioterapeutas podem consultar a lista de pacientes pendentes

### Regras Adicionais
- Apenas novos pacientes podem ser pré-cadastrados.
- Cada paciente pode ter apenas uma ficha.
- O status da ficha só pode ser alterado por fisioterapeutas e quando estão vinculados à ficha.

## Endpoints da API
| Endpoint | Método | Parâmetros de Requisição | Códigos de Resposta             | Descrição                                           |
|----------|--------|--------------------------|--------------------------------|-----------------------------------------------------|
| /users   | POST   | name, username, email, password | 201 Criado, 409 Conflito, 500 Erro Interno do Servidor | Cria um novo usuário com as informações fornecidas. Retorna os detalhes do usuário criado, exceto a senha. |

## Segurança e Conformidade
- Autenticação e autorização de usuários.
- Proteção de dados sensíveis e conformidade com regulamentações de privacidade.

## Guia de Instalação e Configuração
- _[Instruções detalhadas para instalação e configuração da aplicação]_

## Uso da Aplicação
- _[Instruções sobre como usar a aplicação]_

## Contribuições e Colaborações
- _[Como contribuir para o projeto]_
- _[Código de Conduta para colaboradores]_

## Testes
- _[Instruções para execução de testes automatizados e informações sobre cobertura de testes]_

## Perguntas Frequentes (FAQ)
- _[Respostas para dúvidas comuns sobre a aplicação]_

## Licença
- _[Tipo de licença sob a qual o projeto está disponibilizado]_

## Contato
- _[Suas informações de contato para mais informações ou dúvidas]_

## Agradecimentos
- _[Agradecimentos a colaboradores, mentores ou qualquer pessoa que contribuiu significativamente para o projeto]_

## Monitoramento e Logs
- Implementação de logs para monitoramento de atividades.
- Utilização de ferramentas de monitoramento de aplicações.
