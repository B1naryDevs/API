package com.example.emprego;

public class Candidato {

    //Atributos
    private static String nome;
    private static Long cpf;
    private static String dataNac;
    private static String email;
    private static String senha;
    private static Long telefone;

    private static String expEmpresa;
    private static String cargo;
    private static String expInicio;
    private static String expTermino;
    private static String descricao;
    private static String cargoAtual;
    private static String cargoInteresse;
    private static String pretSalarial;

    private static String competencia;
    private static String instituicao;
    private static String cursoInicio;
    private static String cursoTermino;
    private static String idioma;
    private static String curso;

    public Candidato(){}

    public Candidato(String nome, Long cpf,String dataNac,String email,String senha,Long telefone,String expEmpresa,
                     String cargo,String expInicio,String expTermino,String descricao,String cargoAtual,String cargoInteresse,String pretSalarial,String competencia,
                     String instituicao,String cursoInicio,String cursoTermino,String idioma,String curso){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNac = dataNac;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.expEmpresa = expEmpresa;
        this.cargo = cargo;
        this.expInicio = expInicio;
        this.expTermino = expTermino;
        this.descricao = descricao;
        this.cargoAtual = cargoAtual;
        this.cargoInteresse = cargoInteresse;
        this.pretSalarial = pretSalarial;
        this.competencia = competencia;
        this.instituicao = instituicao;
        this.cursoInicio = cursoInicio;
        this.cursoTermino = cursoTermino;
        this.idioma = idioma;
        this.curso = curso;
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getDataNac() {
        return this.dataNac;
    }

    public void setDataNac(String dataNac) {
        this.dataNac = dataNac;
    }
    public String getCargoAtual() {
        return this.cargoAtual;
    }

    public void setCargoAtual(String cargoAtual) {
        this.cargoAtual = cargoAtual;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getTelefone() {
        return this.telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getExpEmpresa() {
        return expEmpresa;
    }

    public void setExpEmpresa(String expEmpresa) {
        this.expEmpresa = expEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getExpInicio() {
        return expInicio;
    }

    public void setExpInicio(String expInicio) {
        this.expInicio = expInicio;
    }

    public String getExpTermino() {
        return expTermino;
    }

    public void setExpTermino(String expTermino) {
        this.expTermino = expTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCargoInteresse() {
        return cargoInteresse;
    }

    public void setCargoInteresse(String cargoInteresse) {
        this.cargoInteresse = cargoInteresse;
    }

    public float getPretSalarial() {
        return Float.parseFloat(pretSalarial);
    }

    public void setPretSalarial(String pretSalarial) {
        this.pretSalarial = pretSalarial;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCursoInicio() {
        return cursoInicio;
    }

    public void setCursoInicio(String cursoInicio) {
        this.cursoInicio = cursoInicio;
    }

    public String getCursoTermino() {
        return cursoTermino;
    }

    public void setCursoTermino(String cursoTermino) {
        this.cursoTermino = cursoTermino;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
