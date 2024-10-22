import time
import psycopg2
from flask import Flask, render_template, request, url_for, redirect, jsonify

app = Flask(__name__)

def get_db_connection():
    conn = psycopg2.connect(host='localhost',
        	database="tfa_gimnasio",
            # user=os.environ['DB_USERNAME'],
            user="postgres",
            # password=os.environ['DB_PASSWORD']
            password="1234")
    return conn

@app.route('/')
def index():
    conn = get_db_connection()
    cur = conn.cursor()
    cur.execute('SELECT * FROM Socio;')
    vals = cur.fetchall()
    cur.close()
    conn.close()
    return render_template('index.html', vals=vals)

@app.route('/about/', methods=('GET', 'POST'))
def about():
    return render_template('about.html')

@app.route('/create/', methods=('GET', 'POST'))
def create():
    try:
        if request.method == 'POST':
            dni = request.form['dni']
            name = request.form['name']
            tlf = int(request.form['tlf'])
            id = int(request.form['id'])

            conn = get_db_connection()
            cur = conn.cursor()
            cur.execute('INSERT INTO Socio (dni, nombre, n_telefono, id_socio)'
                        'VALUES (%s, %s, %s, %s)',
                        (dni, name, tlf, id))
            conn.commit()
            cur.close()
            conn.close()
            return redirect(url_for('index'))
        return render_template('create.html')
    
    except Exception as e:
        return jsonify(error=str(e)), 500

@app.route('/patch/', methods=['GET', 'POST'])
def patch():

    try:
        sql = """UPDATE Socio SET nombre = %s, n_telefono = %s WHERE dni = %s"""

        if request.method == 'POST':
            dni = request.form['dni']
            name = request.form['name']
            tlf = int(request.form['tlf'])

            conn = get_db_connection()
            cur = conn.cursor()
            cur.execute(sql,(name, tlf, dni))
            conn.commit()
            cur.close()
            conn.close()
            return redirect(url_for('index'))

        return render_template('patch.html')
    
    except Exception as e:
        return jsonify(error=str(e)), 500

@app.route('/delete/', methods=['GET', 'POST'])
def delete():

    try:
        sql = """ DELETE FROM Socio WHERE id_socio = %s """
        if request.method == 'POST':
            id = request.form['id']

            conn = get_db_connection()
            cur = conn.cursor()
            cur.execute(sql,(id))
            conn.commit()
            cur.close()
            conn.close()
            return redirect(url_for('index'))

        return render_template('delete.html')
    
    except Exception as e:
        return jsonify(error=str(e)), 500