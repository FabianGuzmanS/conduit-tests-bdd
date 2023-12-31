#!groovy
import java.text.SimpleDateFormat
def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = "fabian_guzmans@outlook.com"

pipeline {
    agent any
    stages {
        stage('Obtener fuentes') {
            steps {
                checkout(
                [$class: 'GitSCM', branches: [[name: "master"]],
                wdoGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: "github_auth_credentials", url: "https://github.com/FabianGuzmanS/conduit-tests-bdd.git"]]])
                //git branch: 'master', credentialsId: 'github_auth_credentials', url: 'https://github.com/FabianGuzmanS/conduit-tests-bdd.git'
            }
        }
        stage('Ejecutar tests') {
            steps {
                script {
                    try {
                        bat "gradle clean test aggregate -Denvironment=${ambiente}"
                        echo 'Test ejecutados sin fallo'
                        currentBuild.result = 'SUCCESS'
                    } catch(ex) {
                        echo 'Test Ejecutados con Fallo'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
        stage('Analisis SonarQube') {
            steps {
                script {
                    scannerHome = tool 'sonarqube_scanner'
                }
                withSonarQubeEnv('sonarqube_server') {
                    bat "${scannerHome}/bin/sonar-scanner.bat"
                }
            }
        }
        stage('Publicar resultados') {
            steps {
                script {
                    publishHTML([
                            reportName: "Reporte_resultados_automatizacion_Conduit_Website_${timestamp}",
                            reportDir: "${WORKSPACE}//target",
                            reportFiles: 'index.html',
                            reportTitles: 'Proyecto Conduit tests bdd',
                            escapeUnderscores: false,
                            allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true
                    ])
                    echo 'Reporte Serenity Html realizado con exito'
                }
            }
        }
        stage('Notificar') {
            steps {
                script {
                    if (currentBuild.result == 'UNSTABLE')
                        currentBuild.result = 'FAILURE'
                    if (currentBuild.result == 'SUCCESS')
                        emailext(
                            subject: "PROYECTO CONDUIT TESTS BDD - EJECUCION EXITOSA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                            body: """<p><b style="color:MediumSeaGreen;">EJECUCION EXITOSA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>                            <p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
                            to: "${CORREOS}"
                        )
                    if (currentBuild.result == 'FAILURE')
                        emailext(
                            subject: "PROYECTO CONDUIT TESTS BDD - EJECUCION FALLIDA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                            body: """<p><b style="color:red;">EJECUCION FALLIDA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>                            <p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
                            to: "${CORREOS}"
                        )
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}