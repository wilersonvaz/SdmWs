package br.edu.ifsp.ads.pdm.sdmws.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.ads.pdm.sdmws.R
import br.edu.ifsp.ads.pdm.sdmws.ViewModel.SdmWsViewModel
import br.edu.ifsp.ads.pdm.sdmws.databinding.ActivityMainBinding
import br.edu.ifsp.scl.sdm.pa2.sdmws.viewmodel.SdmWsViewModel
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var sdmWsViewModel: SdmWsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        // Instanciando viewmodel e chamando getCurso
        sdmWsViewModel = ViewModelProvider
            .AndroidViewModelFactory(this.application)
            .create(SdmWsViewModel::class.java)

        sdmWsViewModel.cursoMld.observe(this) { curso ->
            val cursoSb = StringBuilder()
            cursoSb.append("Nome: ${curso.nome}\n")
            cursoSb.append("Sigla: ${curso.sigla}\n")
            cursoSb.append("Quantidade de semestres: ${curso.semestres}\n")
            cursoSb.append("Quantidade de horas: ${curso.horas}\n")
            activityMainBinding.cursoTv.text = cursoSb.toString()
        }

        sdmWsViewModel.getCurso()

    }

}