/*
 This file is part of Louhi.

    Louhi is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    Louhi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Louhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package modelo;

import java.util.Calendar;
import java.util.LinkedList;

public class EntidadPDF {
		private String titulo;
		private String autor;
		private int numeroDePaginas;
		private String tema;
		private String palabrasClave;
		private String creador;
		private String productor;
		private Calendar fechaDeCreacion;
		private Calendar fechaDeModificacion;
		private String rawMetadata;
		private LinkedList<String> paginas= new LinkedList<String>();
		private String contenido;//el contenido completo del documento

		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
		}
		public int getNumeroDePaginas() {
			return numeroDePaginas;
		}
		public void setNumeroDePaginas(int numeroDePaginas) {
			this.numeroDePaginas = numeroDePaginas;
		}
		public String getTema() {
			return tema;
		}
		public void setTema(String tema) {
			this.tema = tema;
		}
		public String getPalabrasClave() {
			return palabrasClave;
		}
		public void setPalabrasClave(String palabrasClave) {
			this.palabrasClave = palabrasClave;
		}
		public String getCreador() {
			return creador;
		}
		public void setCreador(String creador) {
			this.creador = creador;
		}
		public String getProductor() {
			return productor;
		}
		public void setProductor(String productor) {
			this.productor = productor;
		}
		public Calendar getFechaDeCreacion() {
			return fechaDeCreacion;
		}
		public void setFechaDeCreacion(Calendar fechaDeCreacion) {
			this.fechaDeCreacion = fechaDeCreacion;
		}
		public Calendar getFechaDeModificacion() {
			return fechaDeModificacion;
		}
		public void setFechaDeModificacion(Calendar fechaDeModificacion) {
			this.fechaDeModificacion = fechaDeModificacion;
		}
		public String getRawMetadata() {
			return rawMetadata;
		}
		public void setRawMetadata(String rawMetadata) {
			this.rawMetadata = rawMetadata;
		}
		public LinkedList<String> getPaginas() {
			return paginas;
		}
		public void setPaginas(LinkedList<String> paginas) {
			this.paginas = paginas;
		}
		public String getContenido() {
			return contenido;
		}
		public void setContenido(String contenido) {
			this.contenido = contenido;
		}

    @Override
    public String toString() {
        return this.autor + this.contenido + this.creador + this.palabrasClave +
                this.productor + this.rawMetadata + this.tema + this.titulo;
    }


}
