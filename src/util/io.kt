package util

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.*


object IO {
  private var sc: Scanner? = null
  private var srcDir: String? = null

  fun getRawInputStream(
    fileName: String,
    root: String = "_raw",
  ): InputStream {
    val dir = "$root/$fileName"
    srcDir = dir
    val file = File(dir)
    return FileInputStream(file)
  }

  object InterviewPrep {
    private var fileName: String? = null
    fun readLine(
      fileName: String,
    ): String? {
      val sc = if(sc == null || fileName != this.fileName) Scanner(getRawInputStream(fileName)).also {
        this.fileName = fileName
        sc = it
      } else sc!!
      if(!sc.hasNext()) {
        return null
      }
      return sc.nextLine()
    }
    fun readIntArray(
      fileName: String,
    ): Array<Int>? {
      val line = InterviewPrep.readLine(fileName)?.trimEnd()
        ?: return null
      val list = line.split(" ")
      return Array(list.size) { list[it].toInt() }
    }
    fun getRawInputStream(
      fileName: String,
    ): InputStream = IO.getRawInputStream(
      fileName = "interview_prep/$fileName"
    )
  }
}