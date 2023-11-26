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
                [$class: 'GitSCM', branches: [[name: "automation_qa"]],
                wdoGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: "github_auth_credentials", url: "https://github.com/FabianGuzmanS/conduit-tests-bdd.git"]]])
                //git branch: 'automation_qa', credentialsId: 'github_auth_credentials', url: 'https://github.com/FabianGuzmanS/reqres-tests-bdd.git'
            }
        }
        stage('Compilar proyecto') {
            steps {
                bat ".\\gradlew assemble"
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
        stage('Publicar resultados') {
            steps {
                script {
                    try {
                        bat "rename \"${WORKSPACE}\\target\" serenity_${timestamp}"
                        echo 'Backup de evidencias realizado con exito'
                        publishHTML([
                            reportName: 'Reporte resultados automatización Conduit Website',
                            reportDir: "${WORKSPACE}//serenity_${timestamp}",
                            reportFiles: 'index.html',
                            reportTitles: 'Proyecto Conduit tests bdd',
                            allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true
                        ])
                        echo 'Reporte Serenity realizado con exito'
                    } catch (e) {
                        echo 'No se realizo el Backup de evidencias'
                        publishHTML([
                            reportName: 'Reporte resultados automatización Conduit Website',
                            reportDir: "${WORKSPACE}//serenity_${timestamp}",
                            reportFiles: 'index.html',
                            reportTitles: 'Proyecto Conduit tests bdd',
                            allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true
                        ])
                        echo 'Reporte Html realizado con exito'
                    }
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