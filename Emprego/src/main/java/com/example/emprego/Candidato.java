package com.example.emprego;

public class Candidato {

    public Candidato(String nome, String cpf,String dataNac,String email,String senha,String telefone,String expEmpresa,
                     String cargo,String expInicio,String expTermino,String descricao,String cargoInteresse,float pretSalarial,String competencia,
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
        this.cargoInteresse = cargoInteresse;
        this.pretSalarial = pretSalarial;
        this.competencia = competencia;
        this.instituicao = instituicao;
        this.cursoInicio = cursoInicio;
        this.cursoTermino = cursoTermino;
        this.idioma = idioma;
        this.curso = curso;
    }

    //Atributos
    private String nome;
    private String cpf;
    private String dataNac;
    private String email;
    private String senha;
    private String telefone;

    private String expEmpresa;
    private String cargo;
    private String expInicio;
    private String expTermino;
    private String descricao;
    private String cargoInteresse;
    private float pretSalarial;

    private String competencia;
    private String instituicao;
    private String cursoInicio;
    private String cursoTermino;
    private String idioma;
    private String curso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNac() {
        return dataNac;
    }

    public void setDataNac(String dataNac) {
        this.dataNac = dataNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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
        return pretSalarial;
    }

    public void setPretSalarial(float pretSalarial) {
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
