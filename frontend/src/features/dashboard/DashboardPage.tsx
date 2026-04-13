import { LineChart, Line, XAxis, YAxis, Tooltip, ResponsiveContainer } from 'recharts';

const data = [{d:'W1',s:58},{d:'W2',s:63},{d:'W3',s:71},{d:'W4',s:76}];
export function DashboardPage() {
  return <section className="grid gap-4 md:grid-cols-2"><div className="card"><h2>Score Trend</h2><div className="h-64"><ResponsiveContainer><LineChart data={data}><XAxis dataKey="d"/><YAxis/><Tooltip/><Line dataKey="s" stroke="#22d3ee"/></LineChart></ResponsiveContainer></div></div><div className="card">Strongest vs weakest technologies and interview streak widgets.</div></section>;
}
